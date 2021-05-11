import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from './pages/home/home-page.component';
import { CpuPageComponent } from './pages/cpu/cpu-page.component';
import { SensorsPageComponent } from './pages/sensors/sensors-page.component';
import { FileSystemsPageComponent } from './pages/filesystems/filesystems-page.component';

const routes: Routes = [
  { path: '', component: HomePageComponent},
  { path: 'cpu', component: CpuPageComponent},
  { path: 'sensors', component: SensorsPageComponent},
  { path: 'filesystems', component: FileSystemsPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
