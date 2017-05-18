package model

import org.joda.time.DateTime
import play.api.libs.json.Format
import play.api.libs.json.JsSuccess
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.libs.json.Writes

object _lazy {

  class Lazy[@specialized T](_v: => T) {
    lazy val v = _v
  }

  implicit def fmtLazy[T: Format]: Format[Lazy[T]] =
    Format(Reads(v => JsSuccess(new Lazy(v.as[T]))), Writes(l => Json.toJson(l.v)))

  implicit val readsCustomer = Json.format[Customer]
  implicit val readsLocation = Json.format[Location]
  implicit val readsAddress = Json.format[Address]
  implicit val readsOrder = Json.format[Order]

  implicit val readsPhoneNumber = Json.format[PhoneNumber]
  implicit val readsOrderItem = Json.format[OrderItem]
  implicit val readsDeviceInfo = Json.format[DeviceInfo]
  implicit val readsModel = Json.format[Transaction]

  case class Customer(
    customerNumber: Option[Lazy[String]],
    dateOfBirth: Option[Lazy[DateTime]],
    firstName: Option[Lazy[String]],
    lastName: Option[Lazy[String]],
    accountCreated: Option[Lazy[DateTime]],
    email: Option[Lazy[String]]
  )

  case class Address(
    location: Option[Lazy[Location]],
    addressType: Option[Lazy[String]],
    addressSuffix: Option[Lazy[String]],
    firstName: Option[Lazy[String]],
    lastName: Option[Lazy[String]],
    fullName: Option[Lazy[String]],
    parcelShop: Option[Lazy[Boolean]],
    street: Option[Lazy[String]],
    houseNumber: Option[Lazy[String]],
    city: Option[Lazy[String]],
    country: Option[Lazy[String]],
    postalCode: Option[Lazy[String]]
  )

  case class Order(
    created: Option[Lazy[DateTime]],
    orderOrigin: Option[Lazy[String]]
  )

  case class Location(
    lat: Lazy[Double],
    lon: Lazy[Double]
  )

  case class PhoneNumber(
    phoneNumber: Lazy[String],
    region: Option[Lazy[String]],
    location: Option[Lazy[Location]]
  )

  case class OrderItem(pricePerArticle: Lazy[Double])

  case class DeviceInfo(
    exactId: Option[Lazy[String]],
    smartId: Option[Lazy[String]]
  )

  case class Transaction(
    id: Lazy[String],
    accountId: Lazy[String],
    eventTime: Lazy[DateTime],
    customer: Lazy[Customer],
    addresses: Lazy[List[Address]],
    devices: Lazy[List[DeviceInfo]],
    order: Lazy[Order],
    orderItems: Lazy[List[OrderItem]],
    phoneNumbers: Option[Lazy[List[PhoneNumber]]]
  )

}
