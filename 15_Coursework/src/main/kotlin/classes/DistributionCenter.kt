package classes

class DistributionCenter(numDischargePort: Int, numLoadPort: Int) {

    var dischargeCenter = DischargeCenter(numDischargePort, Warehouse)
    var loadCenter = LoadCenter(numLoadPort)

}