
import {Injectable} from "@angular/core";
import {Sensor} from "./sensor.model";
import {StaticDataSource} from "./static.datasource";
import {timer} from 'rxjs/observable/timer';

@Injectable()
export class SensorsRepository {

  private sensors: Sensor[] = [];

  constructor(private dataSource: StaticDataSource) {

    timer(0, 3000)
      .subscribe(() => {
        this.dataSource.getSensors().subscribe(
          data => {
            this.sensors = data;
          }
        );
      });
  }

  getSensors(): Sensor[] {
    return this.sensors;
  }

  ngOnDestroy(){

  }

}
