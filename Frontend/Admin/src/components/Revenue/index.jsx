import React from "react";
import { Bar, Bubble, Line, Pie } from "react-chartjs-2";
import "./styles.scss";
import Export from "./../ExportExcel/ExportExcel";
import { useEffect } from "react";
import { useState } from "react";
import { getSalesYear } from "../../app/ApiResult";
function Revenue(props) {
  const [saleMonth, setSaleMonth] = useState([]);
  const [saleMonthV, setSaleMonthV] = useState([]);
  function HandelSaleYear(Data) {
    let List = {
      Month: [],
      Value: [],
    };
    let k = 0;
    for (let i = 1; i <= 12; i++) {
      List.Month.push(i);
      
      if (Data[k]?.Month === i) {
        console.log(Data[k])
        List.Value.push(Data[k++]?.Sales);
      } else {
        List.Value.push(0);
      }
    }
    setSaleMonth(List?.Month);
    setSaleMonthV(List?.Value);
  }
  // eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(async () => {
    const res = await getSalesYear();
    if (res) HandelSaleYear(res);
  }, []);
  const dataDay = {
    labels: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24],
    datasets: [
      {
        label: "Doanh thu (triệu)",
        data: [65, 59, 80, 81, 56, 55, 40],
        fill: false,
        borderColor: "rgb(75, 192, 192)",
        tension: 0.1,
      },
    ],
  };
  const dataWeek = {
    labels: ["Coffee", "Sách", "Khác"],
    datasets: [
      {
        label: "Sản phẩm bán chạy",
        data: [300, 50, 100],
        backgroundColor: [
          "rgb(255, 99, 132)",
          "rgb(54, 162, 235)",
          "rgb(255, 205, 86)",
        ],
        hoverOffset: 4,
      },
    ],
  };
  const dataYear = {
    labels: saleMonth,
    datasets: [
      {
        label: "Doanh Thu Tháng(VND)",
        data: saleMonthV,
        backgroundColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 159, 64, 0.2)",
          "rgba(255, 205, 86, 0.2)",
          "rgba(75, 192, 192, 0.2)",
          "rgba(54, 162, 235, 0.2)",
          "rgba(153, 102, 255, 0.2)",
          "rgba(201, 203, 207, 0.2)",
        ],
        borderColor: [
          "rgb(255, 99, 132)",
          "rgb(255, 159, 64)",
          "rgb(255, 205, 86)",
          "rgb(75, 192, 192)",
          "rgb(54, 162, 235)",
          "rgb(153, 102, 255)",
          "rgb(201, 203, 207)",
        ],
        borderWidth: 1,
      },
    ],
  };
  const dataMonth = {
    datasets: [
      {
        label: "Doanh Thu Tuần(Triệu)",
        data: [
          {
            x: 1,
            y: 2,
            r: 1,
          },
          {
            x: 0,
            y: 0,
            r: 0,
          },
        ],
        backgroundColor: "rgb(255, 99, 132)",
      },
    ],
  };

  return (
    <>
      <div className="export">
        <Export name={"Export"} />
      </div>
      <div className="Revenue">
        <div className="Revenue__Day">
          <h5 className="Title_Revenue color_day">Doanh Thu Hôm Nay</h5>
          <Line
            data={dataDay}
            width={100}
            height={200}
            options={{ maintainAspectRatio: false }}
          />
        </div>
        <div className="Revenue__Week">
          <h5 className="Title_Revenue color_week">Doanh Thu Tuần</h5>
          <Pie
            data={dataWeek}
            width={100}
            height={200}
            options={{ maintainAspectRatio: false }}
          />
        </div>
        <div className="Revenue__Month">
          <h5 className="Title_Revenue color_month">Doanh Thu Tháng</h5>
          <Bubble
            data={dataMonth}
            width={100}
            height={200}
            options={{ maintainAspectRatio: false }}
          />
        </div>
        <div className="Revenue__Year">
          <h5 className="Title_Revenue color_year">Doanh Thu Năm</h5>
          <div className="months_of_Year">
            <Bar
              data={dataYear}
              width={100}
              height={100}
              options={{ maintainAspectRatio: false }}
            />
          </div>
        </div>
      </div>
    </>
  );
}

export default Revenue;
