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

  ngOnInit(): void {
    this.advsLatest = this.advService.getLatest(10);
  }
}
