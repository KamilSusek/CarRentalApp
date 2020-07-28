import React from "react";
import { Container, Paper } from "@material-ui/core";
import { useSelector } from "react-redux";
import RequestInfo from "./rentRequestInfo/RequestInfo";
import RentRequestControlPanel from "./rentRequestInfo/RentRequestControlPanel";
import { selectCurrentRequest } from "../../../features/rent-requests/rentRequestsSlice";
import { rentRequestStyles } from "./rentRequestInfo/rentRequest.styles";

const SingleRequest = () => {
  const request = useSelector(selectCurrentRequest);
  const classes = rentRequestStyles();
  return (
    <Container>
      <Paper className={classes.paper}>
        <RequestInfo request={request} />
        <RentRequestControlPanel />
      </Paper>
    </Container>
  );
};

export default SingleRequest;
