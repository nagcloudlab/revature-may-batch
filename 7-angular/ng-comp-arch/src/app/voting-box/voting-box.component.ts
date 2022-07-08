import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-voting-box',
  templateUrl: './voting-box.component.html',
  styleUrls: ['./voting-box.component.css']
})
export class VotingBoxComponent implements OnInit {

  // fetch from data backed-end
  items = [
    "java",
    "spring",
    "javascript",
    "angular"
  ]

  summary: any = {}

  handleNewVote(event: any) {
    let { item, likes, dislikes } = event
    this.summary[item] = {
      likes,
      dislikes
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
