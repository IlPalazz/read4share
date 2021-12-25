import { Book } from './Book';
import { Condition } from './Condition';
import { City } from './City';

export interface AdvDetails {
  advId: number;
  advDescr: string;
  advPrice: number;
  advShipCost: number;
  advPublDate: Date;
  advSaleDate: Date;
  advPicPath: string;
  advLocation: City;
  book: Book;
  condition: Condition;
  sellerUsername: string;
}
