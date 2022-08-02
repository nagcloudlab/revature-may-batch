import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VipPipe } from './vip.pipe';
import { PostComponent } from './post/post.component';
import { PostListComponent } from './post-list/post-list.component';



@NgModule({
  declarations: [
    VipPipe,
    PostComponent,
    PostListComponent,
  ],
  exports: [
    PostListComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PostsModule { }
