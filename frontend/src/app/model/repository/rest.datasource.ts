import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import {Os} from "../os.model";
import {FileSystem} from "../filesystem.model";
import {Sensor} from "../sensor.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Cpu} from "../cpu.model";

@Injectable()
export class RestDataSource {

  apiUrl = environment.backend + '/api';

  constructor(private httpClient: HttpClient) {}

  getOs(): Observable<Os> {
    return this.httpClient.get<Os>(this.apiUrl + '/os');
  }

  getFileSystems(): Observable<FileSystem[]> {
    return this.httpClient.get<FileSystem[]>(this.apiUrl + '/filesystems');
  }

  getSensors(): Observable<Sensor[]> {
    return this.httpClient.get<Sensor[]>(this.apiUrl + '/sensors');
  }

  getCpu(): Observable<Cpu> {
    return this.httpClient.get<Cpu>(this.apiUrl + '/cpu');
  }
}
