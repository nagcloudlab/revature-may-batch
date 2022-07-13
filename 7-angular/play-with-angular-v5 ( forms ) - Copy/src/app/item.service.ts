import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {tap} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  apiUrl: string = "http://localhost:8181/api/items"

  items = []
  reviews: any = {}


  constructor(
    private httpClient: HttpClient
  ) {
  }

  getItems() {
    return this.httpClient.get(this.apiUrl)
      .pipe(tap((response: any) => {
        this.items = response
      }))
  }

  getReviews(itemId: number) {
    return this.httpClient.get(`${this.apiUrl}/${itemId}/reviews`)
  }

  saveNewReview(itemId: number, review: any) {
    return this.httpClient.post(`${this.apiUrl}/${itemId}/reviews`, review)
      .pipe(tap((response: any) => {
        let existingReviews = this.reviews[itemId] || []
        existingReviews.unshift(review)
        this.reviews[itemId] = existingReviews;
      }))

  }

}
