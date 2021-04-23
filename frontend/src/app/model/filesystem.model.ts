
export class FileSystem {

  private availHuman: string;
  private percentUsed: number;

  constructor (
    private name?: string,
    private mountOn?: string,
    private total?: number,
    private used?: number,
    private avail?: number
  ) {
    this.setPersentUsed();
    this.setAvail();
  }

  private setPersentUsed(): void {
    this.percentUsed = 100 - Math.round((this.avail / this.total) * 100);
  }

  private setAvail(): void {
    // Начальная единица - Kb
    let unit = [
      {name: "Tb", value: 1024 * 1024 * 1024},
      {name: "Gb", value: 1024 * 1024},
      {name: "Mb", value: 1024},
      {name: "Kb", value: 1}
    ];

    let valueHuman: number;
    for (let i = 0; i < unit.length; i++) {
      valueHuman = this.avail / unit[i].value;
      if (valueHuman > 1) {
        this.availHuman = Math.round(valueHuman).toString() + unit[i].name;
        break;
      }
    }
  }

  static assign(item: any): FileSystem {
    return new FileSystem(
      item.name,
      item.mountOn,
      item.total,
      item.used,
      item.avail
    );
  }
}
