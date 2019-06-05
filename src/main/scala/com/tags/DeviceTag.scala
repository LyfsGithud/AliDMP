package com.tags

import com.common.Tags
import org.apache.spark.sql.Row

/**
  * 功能描述:
  * 〈 设备标签 〉
  *
  * @since: 1.0.0
  * @Author:SiXiang
  * @Date: 2019/6/5 19:09
  */
object DeviceTag extends Tags {
  override def makeTags(args: Any*): List[(String, Int)] = {
    var list = List[(String, Int)]()
    val row = args(0).asInstanceOf[Row]
    //设备操作系统
    val client = row.getAs[Int]("client")
    client match {
      case 1 => list :+= ("D00010001", 1)
      case 2 => list :+= ("D00010002", 1)
      case 3 => list :+= ("D00010003", 1)
      case _ => list :+= ("D00010004", 1)
    }
    //设备联网方式
    val networkName = row.getAs[String]("networkmannername")
    networkName match {
      case "WIFI" => list :+= ("D00020001", 1)
      case "4G" => list :+= ("D00020002", 1)
      case "3G" => list :+= ("D00020003", 1)
      case "2G" => list :+= ("D00020004", 1)
      case _ => list :+= ("D00020005", 1)
    }
    //设备运营商方式
    val ispName = row.getAs[String]("ispname")
    ispName match {
      case "移动" => list :+= ("D00030001", 1)
      case "联通" => list :+= ("D00030002", 1)
      case "电信" => list :+= ("D00030003", 1)
      case _ => list :+= ("D00030004", 1)
    }
    list
  }
}
