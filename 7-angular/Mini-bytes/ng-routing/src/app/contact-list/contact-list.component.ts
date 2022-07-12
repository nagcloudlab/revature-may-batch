import { Component, OnInit } from '@angular/core';
import { ContactService } from '../contact.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {

  contacts:Array<any>=[]

  constructor(private contactService: ContactService) { }

  ngOnInit(): void {
    this.contacts=this.contactService.getContacts()
  }

}
