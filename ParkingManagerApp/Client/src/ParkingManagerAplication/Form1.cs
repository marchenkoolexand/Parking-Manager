using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace $safeprojectname$
{
    public partial class MainForm : Form
    {
        ParkingManagerService.ParkingAppManagerClient client = new ParkingManagerService.ParkingAppManagerClient();

        public MainForm()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void loadGarageByIdButton_Click(object sender, EventArgs e)
        {

            try
            {
                var garage = client.loadGarage(Int32.Parse(LoadGarageIdTextField.Text));
                loadedGarageIdField.Text = garage.id + "";
                loadedGarageIdField.ForeColor = System.Drawing.Color.Green;
                loadedGarageCityField.Text = garage.city;
                loadedGarageCityField.ForeColor = System.Drawing.Color.Green;
                loadedGarageStreetField.Text = garage.street;
                loadedGarageStreetField.ForeColor = System.Drawing.Color.Green;
                loadedGarageBuildingNumberField.Text = garage.building_number + "";
                loadedGarageBuildingNumberField.ForeColor = System.Drawing.Color.Green;
                loadGarageResultField.Text = "Garage loaded!";
                loadGarageResultField.ForeColor = System.Drawing.Color.Green;

            }
            catch (Exception exception)
            {
                loadedGarageIdField.Text = "unknown";
                loadedGarageIdField.ForeColor = System.Drawing.Color.Red;
                loadedGarageCityField.Text = "unknown";
                loadedGarageCityField.ForeColor = System.Drawing.Color.Red;
                loadedGarageStreetField.Text = "unknown";
                loadedGarageStreetField.ForeColor = System.Drawing.Color.Red;
                loadedGarageBuildingNumberField.Text = "unknown";
                loadedGarageBuildingNumberField.ForeColor = System.Drawing.Color.Red;
                loadGarageResultField.Text = "Garage not been loaded";
                loadGarageResultField.ForeColor = System.Drawing.Color.Red;

            }

        }

        private void addNewGarageButton_Click(object sender, EventArgs e)
        {
            try
            {
                String city = addGarageCityField.Text;
                String street = addGarageStreetField.Text;
                String buildingNumber = addGarageBuildingField.Text;

                bool result = client.addNewGarage(city, street, Int32.Parse(buildingNumber));

                if (result)
                {
                    addNewGarageResultField.Text = "New garage was add successfully";
                    addNewGarageResultField.ForeColor = System.Drawing.Color.Green;
                }
                else
                {
                    addNewGarageResultField.Text = "New garage was not add";
                    addNewGarageResultField.ForeColor = System.Drawing.Color.Red;
                }


            }
            catch (Exception exception)
            {
                addNewGarageResultField.Text = "New garage was not add";
                addNewGarageResultField.ForeColor = System.Drawing.Color.Red;
            }

        }

        private void deleteGarageButton_Click(object sender, EventArgs e)
        {

            String garageId = deleteGarageIdField.Text;
            try
            {


                client.deleteGarage(Int32.Parse(garageId));

                deleteGarageResultField.Text = "Garage with id: " + garageId + " deleted";
                deleteGarageResultField.ForeColor = System.Drawing.Color.Green;

            }
            catch (Exception exception)
            {
                deleteGarageResultField.Text = "   Garage with id: " + garageId + " not deleted, perhaps garage\n contain some cars or not exist at all";
                deleteGarageResultField.ForeColor = System.Drawing.Color.Red;
            }
        }

        private void updateGarageButton_Click(object sender, EventArgs e)
        {

            try
            {
                String field = "";
                if (updateGarageByCityRadioButton.Checked)
                {
                    field = "city";

                }
                else if (updateGarageByStreetRadioButton.Checked)
                {
                    field = "street";

                }
                else if (updateGarageByBuildingNumberRadioButton.Checked)
                {
                    field = "building";

                }


                String newData = updateGarageNewData.Text;
                String garageID = updateGarageIdTextField.Text;

                client.updateGarage(field, newData, Int32.Parse(garageID));

                updateGarageResultField.Text = "Garage " + garageID + " was updated successful, new " + field + " is " + newData + "";
                updateGarageResultField.ForeColor = System.Drawing.Color.Green;

            }
            catch (Exception exception)
            {
                updateGarageResultField.Text = "Garage not been updated";
                updateGarageResultField.ForeColor = System.Drawing.Color.Red;
            }

        }

        private void loadCarButton_Click(object sender, EventArgs e)
        {

            try
            {
                var car = client.loadCar(Int32.Parse(loadCarIdTextField.Text));

                loadedCarIdField.Text = car.id + "";
                loadedCarIdField.ForeColor = System.Drawing.Color.Green;
                loadedCarBrandField.Text = car.brand;
                loadedCarBrandField.ForeColor = System.Drawing.Color.Green;
                loadedCarModelField.Text = car.model;
                loadedCarModelField.ForeColor = System.Drawing.Color.Green;
                loadedCarYearField.Text = car.year + "";
                loadedCarYearField.ForeColor = System.Drawing.Color.Green;
                loadedCarColorFIeld.Text = car.color;
                loadedCarColorFIeld.ForeColor = System.Drawing.Color.Green;
                loadedCarPlateNumberField.Text = car.plate_number;
                loadedCarPlateNumberField.ForeColor = System.Drawing.Color.Green;
                loadedCarOwnerIdField.Text = car.owner.id + "";
                loadedCarOwnerIdField.ForeColor = System.Drawing.Color.Green;
                loadCarResultField.Text = "Car loaded sucsesful!";
                loadCarResultField.ForeColor = System.Drawing.Color.Green;
            }
            catch (Exception exception)
            {
                loadedCarIdField.Text = "unknown";
                loadedCarIdField.ForeColor = System.Drawing.Color.Red;
                loadedCarBrandField.Text = "unknown";
                loadedCarBrandField.ForeColor = System.Drawing.Color.Red;
                loadedCarModelField.Text = "unknown";
                loadedCarModelField.ForeColor = System.Drawing.Color.Red;
                loadedCarYearField.Text = "unknown";
                loadedCarYearField.ForeColor = System.Drawing.Color.Red;
                loadedCarColorFIeld.Text = "unknown";
                loadedCarColorFIeld.ForeColor = System.Drawing.Color.Red;
                loadedCarPlateNumberField.Text = "unknown";
                loadedCarPlateNumberField.ForeColor = System.Drawing.Color.Red;
                loadedCarOwnerIdField.Text = "unknown";
                loadedCarOwnerIdField.ForeColor = System.Drawing.Color.Red;
                loadCarResultField.Text = "Car not been loaded!";
                loadCarResultField.ForeColor = System.Drawing.Color.Red;
            }
        }

        private void addNewCarButon_Click(object sender, EventArgs e)
        {

            try
            {
                String brand = addNewCarBrandField.Text;
                String model = addNewCarModelField.Text;
                int year = Int32.Parse(addNewCarYearField.Text);
                String plateNumber = addNewCarPlateNumberField.Text;
                String color = addNewCarColorField.Text;
                int ownerId = Int32.Parse(addNewCarOwnerIdField.Text);
                int garageId = Int32.Parse(addCarGarageIdField.Text);

                client.addNewCar(garageId, brand, model, year, color, plateNumber, ownerId);
                addCarResultField.Text = "Car add to DB";
                addCarResultField.ForeColor = System.Drawing.Color.Green;
            }
            catch (Exception exception)
            {
                addCarResultField.Text = "Car not been add!";
                addCarResultField.ForeColor = System.Drawing.Color.Red;
            }

        }

        private void deleteCarButton_Click(object sender, EventArgs e)
        {

            try
            {
                String deleteCarId = DeleteCarIdField.Text;
                client.deleteCar(Int32.Parse(deleteCarId));

                client.deleteCar(Int32.Parse(deleteCarId));

                deleteCarResultField.Text = "Car was deleted";
                deleteCarResultField.ForeColor = System.Drawing.Color.Green;
            }
            catch (Exception exception)
            {
                deleteCarResultField.Text = "Car not been deleted";
                deleteCarResultField.ForeColor = System.Drawing.Color.Red;
            }


        }

        private void updateCarButton_Click(object sender, EventArgs e)
        {

            String field = "";
            try
            {

                if (updateCarBrandRadioButton.Checked)
                {
                    field = "brand";
                }
                else if (updateCarModelRadioButton.Checked)
                {
                    field = "model";
                }
                else if (updateCarYearRadioButton.Checked)
                {
                    field = "year";
                }
                else if (updateCarPlateNumberRadioButton.Checked)
                {
                    field = "plateNumber";
                }
                else if (updateCarColorRadioButton.Checked)
                {
                    field = "color";
                }
                else if (updateCarOwnerIdRadioButton.Checked)
                {
                    field = "ownerId";
                }

                String newData = updateCarNewDataField.Text;
                String carID = updateCarIdField.Text;
                client.updateCar(field, newData, Int32.Parse(carID));

                updateCarResultField.Text = "Car " + carID + " was updated successful, new " + field + " is " + newData + "";
                updateCarResultField.ForeColor = System.Drawing.Color.Green;

            }
            catch (Exception exception)
            {
                updateCarResultField.Text = "Car not been updated";
                updateCarResultField.ForeColor = System.Drawing.Color.Red;
            }

        }

        private void loadOwnerIdButton_Click(object sender, EventArgs e)
        {
            try
            {

                var owner = client.loadOwner(Int32.Parse(loadOwnerIdField.Text));
                loadedOwnerIdField.Text = owner.id + "";
                loadedOwnerIdField.ForeColor = System.Drawing.Color.Green;
                loadedOwnerNameField.Text = owner.name;
                loadedOwnerNameField.ForeColor = System.Drawing.Color.Green;
                loadedOwnerSurnameField.Text = owner.surname;
                loadedOwnerSurnameField.ForeColor = System.Drawing.Color.Green;
                loadOwnerResultField.Text = "Owner loaded sucsesful!";
                loadOwnerResultField.ForeColor = System.Drawing.Color.Green;

            }
            catch (Exception exception)
            {
                loadedOwnerIdField.Text = "unknown";
                loadedOwnerIdField.ForeColor = System.Drawing.Color.Red;
                loadedOwnerNameField.Text = "unknown";
                loadedOwnerNameField.ForeColor = System.Drawing.Color.Red;
                loadedOwnerSurnameField.Text = "unknown";
                loadedOwnerSurnameField.ForeColor = System.Drawing.Color.Red;
                loadOwnerResultField.Text = "Owner loaded sucsesful!";
                loadOwnerResultField.ForeColor = System.Drawing.Color.Red;
            }
        }

        private void addNewOwnerButton_Click(object sender, EventArgs e)
        {
            try
            {
                String name = newOwnerNameField.Text;
                String surname = newOwnerSurnameField.Text;

                client.addNewOwner(name, surname);

                addNewOwnerResultField.Text = "Owner was add sucsesfully";
                addNewOwnerResultField.ForeColor = System.Drawing.Color.Green;

            }
            catch (Exception exception)
            {
                addNewOwnerResultField.Text = "Owner was not add!";
                addNewOwnerResultField.ForeColor = System.Drawing.Color.Red;
            }
        }

        private void deleteOwnerIdButton_Click(object sender, EventArgs e)
        {
            try
            {
                int ownerId = Int32.Parse(deleteOwnerIdFIeld.Text);

                client.deleteOwner(ownerId);

                deleteOwnerResultField.Text = "Owner was deleted!";
                deleteOwnerResultField.ForeColor = System.Drawing.Color.Green;
            }
            catch (Exception exception)
            {
                deleteOwnerResultField.Text = "Owner not deleted,perhaps he have some\n cars, or not exist at all!";
                deleteOwnerResultField.ForeColor = System.Drawing.Color.Red;
            }
        }


        private void updateOwnerButton_Click(object sender, EventArgs e)
        {
            String field = "";

            try
            {
                if (updateOwnerNameRadioButton.Checked)
                {
                    field = "name";
                }
                else if (updateOwnerSurnameRadioButton.Checked)
                {
                    field = "surname";
                }

                String newData = updateOwnerNewDataField.Text;
                int ownerId = Int32.Parse(updateOwnerIdField.Text);
                client.updateOwner(field, newData, ownerId);

                updateOwnerResultField.Text = "Owner " + ownerId + " was updated successful, new " + field + " is " + newData + "";
                updateOwnerResultField.ForeColor = System.Drawing.Color.Green;
            }
            catch (Exception exception)
            {
                updateOwnerResultField.Text = "Owner not been updated ";
                updateOwnerResultField.ForeColor = System.Drawing.Color.Green;
            }
        }

        private void loadAllDataButton_Click(object sender, EventArgs e)
        {

           loadAllDataTreeView.Nodes.Clear();

           ParkingManagerService.garage[] garages =  client.loadAllData();

            int garageIndex = 0;
            int carIndex = 0;
            
            
           foreach (ParkingManagerService.garage g in garages)
            {
                
                if (g is ParkingManagerService.garage)
                {
                    loadAllDataTreeView.Nodes.Add("Id: " + g.id + ",City:" + g.city + ", Street: "+ g.street + ", Building Number: " + g.building_number + "." );
                    ParkingManagerService.car[] cars = g.cars;

                    if (cars != null)
                    {
                        if (cars.Length > 0) {

                            foreach (ParkingManagerService.car p in cars)
                            {
                                ParkingManagerService.car n = p;
                                loadAllDataTreeView.Nodes[garageIndex].Nodes.Add("Car ID:" + n.id + ", Brand : " + n.brand + ", Color: " + n.color + " ,Model: " + n.model + ", Plate Number: " + n.plate_number + " ,Year : " + n.year + " , Owner Id: " + n.owner.id);
                                

                                ParkingManagerService.owner owner = n.owner;
                                loadAllDataTreeView.Nodes[garageIndex].Nodes[carIndex].Nodes.Add("Owner ID: " + owner.id + ", Name: " + owner.name + ", Surname: " + owner.surname);
                                carIndex++;

                            }
                    }
                    }
                    garageIndex++;
                    carIndex = 0;
                }

            }
  
        }

        private void addSampleDataButton_Click(object sender, EventArgs e)
        {
            client.addData();
        }

        
    }
}