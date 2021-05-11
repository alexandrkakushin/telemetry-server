import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { ModelModule } from "../model/model.module";
import { CpuUsageComponent } from "./cpu/cpu-usage.component";
import { FileSystemsDetailComponent } from "./filesystems/filesystems-detail.component";
import { OsDetailComponent } from "./os/os-detail.component";
import { SensorsDetailComponent } from "./sensors/sensors-detail.component";

@NgModule({
  declarations: [
    OsDetailComponent,
    CpuUsageComponent,
    SensorsDetailComponent,
    FileSystemsDetailComponent
  ],  
  imports: [
    BrowserModule,
    ModelModule
  ],
  exports: [
    OsDetailComponent,
    CpuUsageComponent,
    SensorsDetailComponent,
    FileSystemsDetailComponent
  ]
})

export class ComponentsModule {}
