import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AdvOverview } from 'src/app/interfaces/AdvOverview';
import { AdvService } from '../../services/adv.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private advService: AdvService) {}

  advsLatest?: Observable<any>;
  advsBestRate?: Observable<any>;
  advsFreeDel?: Observable<any>;
  advsAsNew?: Observable<any>;

  ngOnInit(): void {
    this.advsLatest = this.advService.getLatest(10);
    this.advsBestRate = this.advService.getBestRate(10);
    this.advsFreeDel = this.advService.getFreeDelivery(10);
    this.advsAsNew = this.advService.getAsNew(10);
  }
}
