
import { Injectable } from "@angular/core";
import  {FileSystem } from "../filesystem.model";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class FileSystemsRepository {

  private fileSystems: FileSystem[] = [];

  constructor(private dataSource: RestDataSource) {
    this.dataSource.getFileSystems().subscribe(
      data => {
        this.fileSystems = [];
        data.forEach(
          (item) => {this.fileSystems.push(FileSystem.assign(item))}
        )
      }
    );
  }

  getFileSystems(): FileSystem[] {
    return this.fileSystems;
  }
}
