import React, { useEffect } from "react";
import {
  Grid,
  Button,
  Box,
  ListItem,
  List,
  Container,
} from "@material-ui/core";
import CarImage from "../../carsListing/CarImage";
import CarInfo from "../../carsListing/CarInfo";
import { useSelector, useDispatch } from "react-redux";
import {
  selectCars,
  chooseCar,
  fetchCars,
  fetchCarImage,
  selectImg,
  changephotoCarIndex,
} from "../../../features/your-cars/yourCarsSlice";

// TODO Fetch users cars from api.

const YourCarsList = () => {
  const dispatch = useDispatch();
  const cars = useSelector(selectCars);
  // const img = useSelector(selectImg);
  const img =
    "https://images.unsplash.com/photo-1542362567-b07e54358753?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80";
  useEffect(() => {
    dispatch(fetchCars());
  }, []);
  let ListStyle = "";
  return (
    <Container
      style={{
        minHeight: "80vh",
        height: "auto",
        height: "100%",
      }}
    >
      <Box display="flex" justifyContent="center" alignItems="center">
        <List>
          {cars.map((car, index) =>
            car.isActive ? (
              <ListItem key={index} style={{ backgroundColor: "#f56f42" }}>
                {/* {dispatch(fetchCarImage(car.licensePlate))} */}
                <Box display="flex">
                  <CarImage src={img} />
                  <CarInfo car={car} />
                </Box>
                <Button
                  variant="outlined"
                  color="primary"
                  onClick={() => {
                    dispatch(chooseCar(index));
                  }}
                >
                  Give the car back
                </Button>
              </ListItem>
            ) : (
              <ListItem key={index}>
                {/* {dispatch(fetchCarImage(car.licensePlate))} */}
                <Box display="flex">
                  <CarImage src={img} />
                  <CarInfo car={car} />
                </Box>
              </ListItem>
            )
          )}
        </List>
      </Box>
    </Container>
  );
};

export default YourCarsList;
