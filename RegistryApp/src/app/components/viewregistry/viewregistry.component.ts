import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {DataserviceService} from '../../services/dataservice.service';
import {Router, ActivatedRoute} from '@angular/router';
import {RegistryService} from '../../services/registry.service';

@Component({
  selector: 'app-viewregistry',
  templateUrl: './viewregistry.component.html',
  styleUrls: ['./viewregistry.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class ViewregistryComponent implements OnInit {

  constructor(
    private dataService: DataserviceService,
    private router: Router,
    private route: ActivatedRoute,
    private registryService: RegistryService
  ) { }

  userId:number = 0;
  regModel:any = {};

  ngOnInit() {
    this.dataService.currentMessage.subscribe(message=>{
      this.userId = message;
    });
    this.registryService.currentMessage.subscribe(message => {
      this.regModel = message;
      console.log(this.regModel);
      
    });
  }

}
