import { Component, OnInit, ViewEncapsulation, Output, EventEmitter } from '@angular/core';
import {DataserviceService} from '../../services/dataservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class HomeComponent implements OnInit {

  userId: number = 0;
  constructor(
    private dataService: DataserviceService,
    private router: Router) { }

  @Output() registryCreated = new EventEmitter<string>();

  ngOnInit() {
    this.dataService.currentMessage.subscribe(message => {
      this.userId = message
      
    });
  }

  onCreateRegistryClick({value, valid}:{value: any, valid:boolean}){
    if(valid){
      this.router.navigate(['/create-registry/'+value.email]);
    }
  }

}
