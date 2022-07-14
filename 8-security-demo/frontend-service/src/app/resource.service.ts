import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  constructor(private httpClient: HttpClient) { }

  getPublicResource(){
    return this.httpClient.get("http://localhost:8181/api/public-resource",{
      responseType:'text'}
    );
  }
  getPrivateResource(){
    return this.httpClient.get("http://localhost:8181/api/private-resource",{
      headers:{
        "Authorization":"Bearer "+localStorage.getItem("auth-token")
      },
      responseType:'text'
    });
  }

}
