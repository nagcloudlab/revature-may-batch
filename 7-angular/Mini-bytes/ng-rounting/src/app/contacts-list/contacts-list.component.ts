import {Component, OnInit} from '@angular/core';
import {ContactsService} from '../contacts.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-contacts-list',
  templateUrl: './contacts-list.component.html',
  styleUrls: ['./contacts-list.component.css']
})
export class ContactsListComponent implements OnInit {

  contacts: Array<any> = []

  constructor(
    private contactsService: ContactsService,
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    // this.contactsService.getContacts()
    //   .subscribe({
    //     next:(contacts:any)=>{
    //       this.contacts=contacts
    //     }
    //   })

    this.route.data.subscribe({
      next: (data: any) => {
        this.contacts = data.contacts
      }
    })

  }

}
