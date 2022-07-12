import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from "@angular/common";
import {ContactsService} from '../contacts.service';

@Component({
  selector: 'app-contacts-detail',
  templateUrl: './contacts-detail.component.html',
  styleUrls: ['./contacts-detail.component.css']
})
export class ContactsDetailComponent implements OnInit {

  contact: any = {}

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private contactsService: ContactsService
  ) {
  }

  ngOnInit(): void {
    //let cId = this.route.snapshot.params['cId']
    this.route.params.subscribe(params=>{
      let cId=params['cId']
      this.contact = this.contactsService.getContactDetails(Number.parseInt(cId))
    })

  }

  back() {
    this.location.back()
  }

}
