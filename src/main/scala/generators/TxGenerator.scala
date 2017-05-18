package generators

import org.joda.time.DateTime
import play.api.libs.json._
import org.scalacheck._
import model.eager._


object TxGenerator {

  import org.scalacheck.Arbitrary
  import org.scalacheck.Gen

  private implicit val asd = Arbitrary[DateTime](Gen.choose(0, 999999999L).map(l => new DateTime(l)))
  private implicit val hh1 = Arbitrary[Customer](Gen.resultOf(Customer))
  private implicit val hh2 = Arbitrary[Order](Gen.resultOf(Order))
  private implicit val hh4 = Arbitrary[Location](Gen.resultOf(Location))
  private implicit val hh5 = Arbitrary[Address](Gen.resultOf(Address))
  private implicit val hh6 = Arbitrary[DeviceInfo](Gen.resultOf(DeviceInfo))
  private implicit val hhu = Arbitrary[OrderItem](Gen.resultOf(OrderItem))
  private implicit val hh1u = Arbitrary[PhoneNumber](Gen.resultOf(PhoneNumber))
  private val tx = Gen.resultOf(Transaction)

  def generate() = Json.toJson(tx.sample.get)

}
