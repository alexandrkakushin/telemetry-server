
export class Sensor {

  constructor (
    public name?: string,
    public lowValue?: number,
    public upperValue?: number,
    public topValue?: number,
    public lowType?: string,
    public upperType?: string) {}


  static assign(item: any): Sensor {
    return new Sensor(
      item.name,
      item.lowValue,
      item.upperValue,
      item.topValue,
      item.lowType,
      item.upperType
    )
  }
}
