import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PublishAdv } from 'src/app/interfaces/PublishAdv';
import { SearchBookResult } from 'src/app/interfaces/SearchBookResult';
import { AdvService } from 'src/app/services/adv.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-publish-adv',
  templateUrl: './publish-adv.component.html',
  styleUrls: ['./publish-adv.component.css'],
})
export class PublishAdvComponent implements OnInit {
  bookForm: any = {
    title: '',
    author: '',
  };
  advForm: any = {
    description: '',
    price: null,
    shipCost: null,
    condCode: '',
    pen: false,
    pencil: false,
    highl: false,
  };
  selectedBook?: SearchBookResult;
  bookChosen: boolean = false;
  searchBookResult: SearchBookResult[] = [];

  constructor(
    private advService: AdvService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSearch() {
    this.bookChosen = false;
    this.selectedBook = undefined;
    this.searchBookResult = [];

    const { title, author } = this.bookForm;

    if (title != '' || author != '') {
      this.advService.searchBook(title, author).subscribe(
        (result) => {
          this.searchBookResult = result;
        },
        (err) => {
          console.log(err.error.message);
        }
      );
    }
  }

  onSelectBook(index: number) {
    this.selectedBook = this.searchBookResult[index];
  }

  onPublish() {
    const { description, price, shipCost, condCode, pen, pencil, highl } =
      this.advForm;

    let request: PublishAdv = {
      bookIsbn: this.selectedBook!.isbn,
      bookTitle: this.selectedBook!.title,
      bookAuthor: this.selectedBook!.author,
      bookPublDate: this.selectedBook!.publDate,
      bookPublisher: this.selectedBook!.publisher,
      bookLanguage: this.selectedBook!.language,
      bookCoverUrl: this.selectedBook!.coverUrl,
      bookCategory: this.selectedBook!.category,
      bookAvgRating: this.selectedBook!.avgRating,
      advDescr: description,
      advPrice: price,
      advShipCost: shipCost,
      sellerId: this.tokenStorageService.getUser()!.id,
      condCode: condCode,
      condPen: pen,
      condPencil: pencil,
      condHighl: highl,
    };
    console.log('Request:');
    console.log(JSON.stringify(request));
    this.advService.publishAdv(request).subscribe(
      () => {
        this.router.navigate(['/home']);
      },
      (err) => {
        console.log(err.error.message);
      }
    );
  }
}
