import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { GlobalStats } from 'src/app/interfaces/GlobalStats';
import { DataService } from 'src/app/services/data.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css'],
})
export class StatsComponent implements OnInit {
  globalStats?: Observable<GlobalStats>;

  constructor(
    private tokenStorageService: TokenStorageService,
    private dataService: DataService,
    private router: Router
  ) {}

  ngOnInit(): void {
    console.log(this.tokenStorageService.getUser());
    if (
      this.tokenStorageService.getToken() == null ||
      !this.tokenStorageService.getUser()?.roles.includes('ROLE_ADMIN')
    )
      this.router.navigate(['/home']);

    // Fetch stats
    this.globalStats = this.dataService.getGlobalStats();
  }
}
