import { Category } from './Category';

export interface Book {
  id: number;
  isbn: string;
  title: string;
  author: string;
  publDate: string;
  publisher: string;
  language: string;
  coverUrl: string;
  avgRating: number;
  category: Category;
}
