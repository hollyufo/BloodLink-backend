import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AuthServiceService } from 'src/app/Service/auth-service.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent {
data: any;

  constructor(private http: HttpClient, private authService: AuthServiceService) {}

  getPosts() {
    this.http.get<any[]>('http://localhost:8081/api/v1/user/posts').subscribe((data: any[]) => {
      console.log(data);
      return this.data = data;
    }, error => {
      console.error(error); // Log any errors to the console
    });
  }

  ngOnInit() {
    this.getPosts();
  }
}
