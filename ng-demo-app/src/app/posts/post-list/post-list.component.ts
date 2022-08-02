import { Component, OnInit } from '@angular/core';
import {Post} from "../model/post";
import { PostsService } from '../posts.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts!:Post[]

  constructor(private postsService: PostsService) { }

  ngOnInit(): void {
    this.postsService.getPosts()
      .subscribe({
        next:(posts: Post[])=>{
          this.posts = posts
        }
      })
  }

}
