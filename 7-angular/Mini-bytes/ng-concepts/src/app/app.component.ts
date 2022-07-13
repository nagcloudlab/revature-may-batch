import {Component} from '@angular/core';
import {FooService} from './foo/foo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ng-concepts';

  constructor(private fooService: FooService) {
  }

  ngOnInit() {
    console.log(this.fooService.getFoo())
  }


  text: string="";

  results: string[]=[];

  dob:string|null="07/26/2022";

  search(event:any) {
    // this.mylookupservice.getResults(event.query).then(data => {
    //   this.results = data;
    // });
    console.log(event.query);
    this.results=[
      "Nag",
      "Indu",
      "Riya",
      "Diya"
    ]
  }

}
