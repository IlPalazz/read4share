import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewEncapsulation,
} from '@angular/core';
import { SearchBookResult } from 'src/app/interfaces/SearchBookResult';
import SwiperCore, { Navigation, Pagination, SwiperOptions } from 'swiper';

// install Swiper modules
SwiperCore.use([Navigation]);
SwiperCore.use([Pagination]);

@Component({
  selector: 'app-book-carousel',
  templateUrl: './book-carousel.component.html',
  styleUrls: ['./book-carousel.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class BookCarouselComponent implements OnInit {
  // List of books to display in the carousel
  @Input() books!: SearchBookResult[];
  @Input() selectedIndex!: number;
  @Output() onSelectBook: EventEmitter<any> = new EventEmitter();
  swiper: any;

  config: SwiperOptions = {
    allowTouchMove: false,
    navigation: true,
    slidesPerView: 1,
    spaceBetween: 10,
    //Responsive breakpoints
    breakpoints: {
      //when window width is >= 320px
      300: {
        slidesPerView: 1,
        spaceBetween: 10,
      },
      700: {
        slidesPerView: 2,
        spaceBetween: -25,
      },
      900: {
        slidesPerView: 3,
        spaceBetween: -10,
      },
    },
  };

  constructor() {}

  ngOnInit(): void {}

  onSwiper(swiper: any) {
    this.swiper = swiper;
  }

  onSelect(index: number) {
    console.log('Carousel select');
    this.selectedIndex = index;
    this.onSelectBook.emit(this.selectedIndex);
  }
}
