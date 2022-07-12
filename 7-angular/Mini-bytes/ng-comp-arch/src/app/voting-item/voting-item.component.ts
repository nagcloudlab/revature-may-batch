import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-voting-item',
  templateUrl: './voting-item.component.html',
  styleUrls: ['./voting-item.component.css']
})
export class VotingItemComponent implements OnInit {


  @Input()
  value = "Unknown"

  @Output()
  vote = new EventEmitter()

  likes = 0; // state / data
  dislikes = 0; // state / data

  doVote(v: number) {
    if (v < 0)
      this.dislikes++
    else
      this.likes++
    this.vote.emit({
      item: this.value,
      likes: this.likes,
      dislikes: this.dislikes
    })
  }

  constructor() { }

  ngOnInit(): void {
  }

}
