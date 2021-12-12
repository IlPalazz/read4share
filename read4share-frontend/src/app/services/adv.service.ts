import { Injectable } from '@angular/core';
import { mockAdvOverview } from 'src/mockAdvOverview';
import { Observable, of } from 'rxjs';
import { AdvOverview } from '../interfaces/AdvOverview';

@Injectable({
  providedIn: 'root',
})
export class AdvService {
  constructor() {}

  getLatest(size: number): Observable<AdvOverview[]> {
    return of(mockAdvOverview);
  }
}
