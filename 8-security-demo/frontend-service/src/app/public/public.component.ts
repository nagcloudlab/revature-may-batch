import {Component, OnInit} from '@angular/core';
import {ResourceService} from '../resource.service';

@Component({
  selector: 'app-public',
  templateUrl: './public.component.html',
  styleUrls: ['./public.component.css']
})
export class PublicComponent implements OnInit {

  resource: string = ""

  constructor(
    private resourceService: ResourceService
  ) {
  }

  ngOnInit(): void {
    this.resourceService.getPublicResource()
      .subscribe({
        next: (r: any) => {
          this.resource = r;
        }
      })
  }

}
