import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-adv-overview',
  templateUrl: './adv-overview.component.html',
  styleUrls: ['./adv-overview.component.css'],
})
export class AdvOverviewComponent implements OnInit {
  @Input() bookTitle!: string;
  @Input() bookAuthor!: string;
  @Input() sellerUsername!: string;
  @Input() advLocation!: string;
  @Input() advPublDate!: string;
  @Input() advPrice!: number;
  @Input() bookCoverUrl!: string;

  constructor() {}

  ngOnInit(): void {}
}
