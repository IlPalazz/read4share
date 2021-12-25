import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-adv-details',
  templateUrl: './adv-details.component.html',
  styleUrls: ['./adv-details.component.css'],
})
export class AdvDetailsComponent implements OnInit {
  advId!: number;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Get the adv id from the current route.
    const routeParams = this.route.snapshot.paramMap;
    this.advId = Number(routeParams.get('advId'));
  }
}
