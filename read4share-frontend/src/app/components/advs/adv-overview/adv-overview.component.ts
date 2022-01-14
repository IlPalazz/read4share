import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adv-overview',
  templateUrl: './adv-overview.component.html',
  styleUrls: ['./adv-overview.component.css'],
})
export class AdvOverviewComponent implements OnInit {
  @Input() advId!: number;
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
