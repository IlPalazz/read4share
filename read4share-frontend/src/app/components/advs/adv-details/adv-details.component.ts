import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdvDetails } from 'src/app/interfaces/AdvDetails';
import { AdvService } from 'src/app/services/adv.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-adv-details',
  templateUrl: './adv-details.component.html',
  styleUrls: ['./adv-details.component.css'],
})
export class AdvDetailsComponent implements OnInit {
  advDetails?: Observable<AdvDetails>;
  condition?: string;

  constructor(
    private route: ActivatedRoute,
    private advService: AdvService,
    private location: Location
  ) {}

  ngOnInit(): void {
    // Get the adv id from the current route.
    const routeParams = this.route.snapshot.paramMap;
    let advId = Number(routeParams.get('advId'));

    // Get the adv details
    this.advDetails = this.advService.getDetails(advId);
  }

  onBack() {
    this.location.back();
  }
}
