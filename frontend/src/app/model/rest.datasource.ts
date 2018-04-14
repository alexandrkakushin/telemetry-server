import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import {Os} from "./os.model";
import {FileSystem} from "./filesystem.model";
import {Sensor} from "./sensor.model";

@Injectable()
export class RestDataSource {

  apiUrl = '/api';

  constructor(private http: Http) {}

  getOs(): Observable<Os> {
    return this.http.get(this.apiUrl + '/os').map(response => response.json() as Os);
  }

  getFileSystems(): Observable<FileSystem[]> {
    return this.http.get(this.apiUrl + '/filesystems').map(response => response.json());
  }

  getSensors(): Observable<Sensor[]> {
    return this.http.get(this.apiUrl + '/sensors').map(response => response.json());
  }
}
