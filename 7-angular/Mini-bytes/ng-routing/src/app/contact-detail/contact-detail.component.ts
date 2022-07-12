import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ContactService} from "../contact.service";

@Component({
  selector: 'app-contact-detail',
  templateUrl: './contact-detail.component.html',
  styleUrls: ['./contact-detail.component.css']
})
export class ContactDetailComponent implements OnInit {

  contactDetail:any={}

  constructor(
    private contactService: ContactService,
    private route:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit(): void {
    // let cname=this.route.snapshot.params['cname']
    // this.contactDetail=this.contactService.getContact(cname)

    this.route.params.subscribe(params =>{
      this.contactDetail=this.contactService.getContact(params['cname'])
    })

  }

  goBack(){
  this.router.navigate(['contact'])
  }

}
