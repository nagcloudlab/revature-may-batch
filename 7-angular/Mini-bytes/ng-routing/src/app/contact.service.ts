import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  family=new Map()

  constructor() {
    this.family.set("Nag",{
      name:"nagabhushanam",
      age:39
    })
    this.family.set("Indu",{
      name:"indumathy",
      age:34
    })
    this.family.set("Riya",{
      name:"riya",
      age:8
    })
    this.family.set("Diya",{
      name:"diya",
      age:3
    })
  }


  getContacts(){
    return [
      "Nag",
      "Indu",
      "Riya",
      "Diya"
    ]
  }

  getContact(key:string){
    return this.family.get(key)
  }

}
