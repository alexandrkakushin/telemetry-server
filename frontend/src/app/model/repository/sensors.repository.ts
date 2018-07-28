
import {Injectable} from "@angular/core";
import {Sensor} from "../sensor.model";
import {timer} from 'rxjs/observable/timer';
import {RestDataSource} from "./rest.datasource";

@Injectable()
export class SensorsRepository {

  private sensors: Sensor[] = [];

  constructor(private dataSource: RestDataSource) {
    timer(0, 3000)
      .subscribe(() => {
        this.dataSource.getSensors().subscribe(
          data => {
            this.sensors = [];
            data.forEach(
              (item) => {this.sensors.push(Sensor.assign(item))}
            );
          }
        );
      });
  }

  getSensors(): Sensor[] {
    return this.sensors;
  }
}
