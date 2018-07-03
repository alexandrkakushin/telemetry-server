
import { NgModule } from "@angular/core";
import {OsRepository} from "./os.repository";
import {FileSystemsRepository} from "./filesystems.repository";
import {SensorsRepository} from "./sensors.repository";
import {RestDataSource} from "./rest.datasource";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [HttpClientModule],
  providers: [
    FileSystemsRepository,
    SensorsRepository,
    OsRepository,
    RestDataSource
    ]
})

export class ModelModule {}
