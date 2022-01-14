import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalStats } from '../interfaces/GlobalStats';

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private http: HttpClient) {}

  getGlobalStats(): Observable<GlobalStats> {
    return this.http.get<GlobalStats>(API_URL + '/stats/global');
  }
}
