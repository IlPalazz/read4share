import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdvDetails } from 'src/app/interfaces/AdvDetails';
import { AdvService } from 'src/app/services/adv.service';
import { Location } from '@angular/common';
import { UserData } from 'src/app/interfaces/UserData';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { ChatService } from 'src/app/services/chat.service';

@Component({
  selector: 'app-adv-details',
  templateUrl: './adv-details.component.html',
  styleUrls: ['./adv-details.component.css'],
})
export class AdvDetailsComponent implements OnInit {
  advDetails?: Observable<AdvDetails>;
  condition?: string;
  user?: UserData | null;

  constructor(
    private route: ActivatedRoute,
    private advService: AdvService,
    private location: Location,
    private tokenStorageService: TokenStorageService,
    private router: Router,
    private chatService: ChatService
  ) {}

  ngOnInit(): void {
    // Get the adv id from the current route.
    const routeParams = this.route.snapshot.paramMap;
    let advId = Number(routeParams.get('advId'));

    // Get the adv details
    this.advDetails = this.advService.getDetails(advId);

    // Get user details
    this.user = this.tokenStorageService.getUser();
  }

  onBack() {
    this.location.back();
  }

  onContactSeller() {
    // Auth guard?
    // 1. Check if user is logged in
    if (this.user == null) this.router.navigate(['/login']);
    else {
      // 2. Create chat between buyer and seller
      // this.chatService.create()
    }
  }

  onHandleAdv() {}
}
