import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import "rxjs/add/observable/from";
import {Os} from "./os.model";
import {FileSystem} from "./filesystem.model";
import {Sensor} from "./sensor.model";

@Injectable()
export class StaticDataSource {

  private os: Os = new Os("i386", "UBUNTU", "17.10");

  private fileSystems: FileSystem[] = [
    new FileSystem("/dev/sda1", "/", 114854020, 50683132),
    new FileSystem("/dev/mmcblk0p1", "/media/ak/0076-19E4", 61914336, 57170400),
    new FileSystem("tmpfs", "/run/lock", 5120, 4)
  ];

  private sensors: Sensor[] = [
    new Sensor("Core 1", 72, 90, 53, "HIGH", "CRIT"),
    new Sensor("Core 0", 72, 90, 59, "HIGH", "CRIT"),
    new Sensor("Package id 0", 72, 90, 59, "HIGH", "CRIT")
  ];

  getOs(): Observable<Os> {
    return Observable.from([this.os]);
  }

  getFileSystems(): Observable<FileSystem[]> {
    return Observable.from([this.fileSystems]);
  }

  getSensors(): Observable<Sensor[]> {
    return Observable.from([this.sensors]);
  }
}
