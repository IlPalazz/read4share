import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { AdvOverview } from 'src/app/interfaces/AdvOverview';
// import Swiper core and required modules
import SwiperCore, { Navigation } from 'swiper';

// install Swiper modules
SwiperCore.use([Navigation]);

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class CarouselComponent implements OnInit {
  // List of Advs Overview to display in the carousel
  @Input() advs?: AdvOverview[];

  constructor() {}

  ngOnInit(): void {}
}
