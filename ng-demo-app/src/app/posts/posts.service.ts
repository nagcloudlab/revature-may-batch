import {Injectable} from '@angular/core';
import {LogService} from "./log.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "./model/post";

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(
    private httpClient: HttpClient,
    private logService: LogService,
  ) {
  }

  getCount() {
    this.logService.log("get count")
    return 1 + 2;
  }

  getPosts():Observable<Post[]> {
    return this.httpClient.get<Post[]>(`https://jsonplaceholder.typicode.com/posts?_limit=5`);
  }

  deletePost(id: number) {
    return this.httpClient.delete(`https://jsonplaceholder.typicode.com/posts/${id}`)
  }


}
