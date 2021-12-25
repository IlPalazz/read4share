import { Category } from './Category';

export interface Book {
  id: number;
  isbn: string;
  title: string;
  author: string;
  publDate: Date;
  publisher: string;
  language: string;
  coverUrl: string;
  avgRating: number;
  category: Category;
}
