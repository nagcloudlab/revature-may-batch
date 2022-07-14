import { Component, OnInit } from '@angular/core';
import {ResourceService} from "../resource.service";

@Component({
  selector: 'app-private',
  templateUrl: './private.component.html',
  styleUrls: ['./private.component.css']
})
export class PrivateComponent implements OnInit {

  resource: string = ""

  constructor(
    private resourceService: ResourceService
  ) {
  }

  ngOnInit(): void {
    this.resourceService.getPrivateResource()
      .subscribe({
        next: (r: any) => {
          this.resource = r;
        }
      })
  }

}
