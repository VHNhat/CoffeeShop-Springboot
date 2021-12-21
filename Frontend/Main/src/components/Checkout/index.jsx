import { Checkbox, Radio } from '@mui/material';
import emailjs from 'emailjs-com';
import jwt_decode from 'jwt-decode';
import { useSnackbar } from 'notistack';
import React, { memo, useContext, useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { CheckoutData, getCustomerById } from '../../app/ApiResult';
import { context } from '../../app/Context';
import { decreaseBill, reset } from '../../app/CounterBill';
import { actionKM } from '../../app/KMOpen';
import Loading from './../Loading/Loading';
import './styles.scss';

function Checkout(props) {
  const [get, SetGet] = useState(
    JSON.parse(localStorage.getItem('LISTBILL') || '[]')
  );
  const { checkToken, address, discount } = useContext(context);
  const [pay, setPay] = useState('tienmat');
  const { enqueueSnackbar } = useSnackbar();
  const [total, setTotal] = useState(0);
  const [preTotal, setPreTotal] = useState(0);
  const [email, setEmail] = useState();
  const [dateEx, setdateEx] = useState();
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);
  const label = { inputProps: { 'aria-label': 'Checkbox demo' } };
  const KMOpen = useSelector((state) => state.KMOpen);
  const dispatch = useDispatch();
  const [dataUser, setDataUser] = useState({
    Address: '',
    Time: '',
    Name: '',
    Phone: '',
    Note: '',
    PayBy: '',
    listBill: get,
    CustomerId: '',
    TotalPrice: 0,
    DiscountId: '',
    CheckDiscount: false,
  });
  const getTotal=()=>{
    return get.reduce((total, item) => {
      return total + item.price;
    }, 0);
  }
  useEffect(() => {
    var Total = getTotal()
    setDataUser({ ...dataUser, TotalPrice: Total });
    setTotal(Total);
    setPreTotal(Total);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [get, discount]);
  useEffect(() => {
    if (discount.ExpiredDate) {

      const date = new Date(discount?.ExpiredDate)[Symbol.toPrimitive]('number');
      setdateEx(date);
      if (discount?.Value && preTotal >= discount?.MinPrice && Date.now() < date) {
        setDataUser({ ...dataUser, CheckDiscount:true,DiscountId:discount?.Id });
        setTotal(() => {
          var Total = getTotal();
          return Total - discount?.Value;
        });
      }
      else {
        setDataUser({ ...dataUser, CheckDiscount:false,DiscountId:discount?.Id });
      }
    }

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [discount, get]);
  function removeItem(index) {
    SetGet(JSON.parse(localStorage.getItem('LISTBILL')) || []);
    if (get.length) {
      SetGet(get.splice(index, 1));
      localStorage.setItem('LISTBILL', JSON.stringify(get));
      SetGet(JSON.parse(localStorage.getItem('LISTBILL')));
      dispatch(decreaseBill());
    }
  }

  // eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(async () => {
    if (checkToken) {
      var decoded = jwt_decode(checkToken);

      if (decoded?.Id) {
        const res = await getCustomerById(decoded?.Id);
        if (res) setEmail(res?.Email);
        setDataUser({
          ...dataUser,
          Name: res?.Name,
          Phone: res?.Phone,
          CustomerId: res?.Id,
        });
      }
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [checkToken]);

  const handleChange = (event) => {
    setPay(event.target.value);
  };
  const handleOnChange = (e) => {
    setDataUser({ ...dataUser, [e.target.name]: e.target.value });
  };
  const controlProps = (item) => ({
    checked: pay === item,
    onChange: handleChange,
    value: item,
    name: 'color-radio-button-demo',
    inputProps: { 'aria-label': item },
  });
  const OnSubmit = async () => {
    setLoading(true);
    console.log(dataUser);
    if (dataUser?.CustomerId) {
      const response = await CheckoutData({
        ...dataUser,
        PayBy: pay,
        TotalPrice: total,
        Address: address?.Address,
      });
      if (response?.status === 200) {
        var templateParams = {
          name: dataUser?.Name,
          message: `Tổng hóa đơn của bạn là: ${total} VND. 
                    Tại địa chỉ: ${address?.Address}. 
                    Phương thức thanh toán: ${pay}. `,
          customerEmail: email
        };
        emailjs
          .send(
            'service_eof9h48',
            'template_ml1wgir',
            templateParams,
            'user_R3y68HqWYo4WqJe11mVu7'
          )
          .then((res) => {
            enqueueSnackbar('Đặt hàng thành công', { variant: 'success' });
            setTimeout(() => {
              localStorage.removeItem('LISTBILL');
              SetGet([]);
              dispatch(reset());
            }, 2000);
          })
          .catch((e) => {
            enqueueSnackbar('Đặt hàng thất bại', { variant: 'error' });
          });
      } else {
        enqueueSnackbar('Đặt hàng thất bại', { variant: 'error' });
      }
    } else {
      enqueueSnackbar('Đặt hàng thất bại', { variant: 'error' });
    }
    setLoading(false);
    setSuccess(true);
  };

  return (
    <div className='Checkout_com'>
      <div className='Checkout_com_Title'>
        <i className='fad fa-file'></i>
        <h3>Xác nhận đơn hàng</h3>
      </div>
      <div className='checkout__body'>
        <div className='body__Pay'>
          <div className='type_buy'>
            <div className='type'>
              <p className='type_Name'>{address?.TitleDelivery}</p>
              <div className='change_type'>
                <label htmlFor='check_choose'>
                  {' '}
                  <p>Đổi phương thức</p>
                </label>
              </div>
            </div>
            <div className='info_type'>
              <div className='info_imgType'>
                <img src={address?.Photo} alt='' />
              </div>
              <div className='info_des'>
                <div className='location '>
                  <label
                    htmlFor='check_choose'
                    style={{
                      width: '100%',
                      display: 'flex',
                      justifyContent: 'space-between',
                    }}>
                    <div>
                      <b>Địa chỉ giao hàng tại </b>
                      <p>
                        {address?.Address || (
                          <div style={{ color: 'red', fontWeight: '550' }}>
                            Bạn chưa nhập địa chỉ giao hàng: <br />
                            Cú pháp: <br /> Số nhà - Tên đường - Quận - Thành
                            phố{' '}
                          </div>
                        )}
                      </p>
                    </div>{' '}
                    <div className='d-flex flex-column justify-content-center'>
                      <i className='fa fa-chevron-right'></i>
                    </div>
                  </label>
                </div>

                <div className='time d-flex justify-content-between'>
                  <div>
                    <b>Nhận đơn từ thứ 2 - Chủ nhật</b>
                    <p>Thời gian: 20-30 phút sau khi đặt hàng</p>
                  </div>
                  <div className='d-flex flex-column justify-content-center'>
                    <i class='fad fa-flag-alt'></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <form action='' method='post'>
            <div className='input_address'>
              <div className='input_info'>
                <input
                  type='text'
                  name='Name'
                  id='Name'
                  onChange={(e) => handleOnChange(e)}
                  value={dataUser?.Name}
                  placeholder='Tên người nhận'
                  required
                />
              </div>
              <div className='input_info'>
                <input
                  type='text'
                  name='Phone'
                  id='Phone'
                  required
                  value={dataUser?.Phone}
                  onChange={(e) => handleOnChange(e)}
                  placeholder='Số điện thoại'
                />
              </div>
              <div className='input_info'>
                <input
                  type='text'
                  name='Note'
                  id='Note'
                  value={dataUser?.Note}
                  onChange={(e) => handleOnChange(e)}
                  placeholder='Thêm hướng dẫn đặt hàng'
                />
              </div>
            </div>

            <div className='pay_for'>
              <p className='type_Name'>Phương thức thanh toán</p>
              <div className='checkpay'>
                <label htmlFor='tienmat'>
                  <Radio
                    {...controlProps('tienmat')}
                    color='default'
                    name='pay'
                    id='tienmat'
                  />
                  <img
                    src='https://minio.thecoffeehouse.com/image/tchmobileapp/1000_photo_2021-04-06_11-17-08.jpg'
                    alt=''
                  />
                  <span>Tiền mặt</span>
                </label>
              </div>
              <div className='checkpay'>
                <label htmlFor='momo'>
                  <Radio
                    {...controlProps('momo')}
                    color='default'
                    name='pay'
                    id='momo'
                  />
                  <img
                    src='https://minio.thecoffeehouse.com/image/tchmobileapp/386_ic_momo@3x.png'
                    alt=''
                  />
                  <span>MoMo</span>
                </label>
              </div>

              <div className='checkpay'>
                <label htmlFor='zalopay'>
                  <Radio
                    {...controlProps('zalopay')}
                    color='default'
                    name='pay'
                    id='zalopay'
                  />
                  <img
                    src='https://minio.thecoffeehouse.com/image/tchmobileapp/388_ic_zalo@3x.png'
                    alt=''
                  />
                  <span>ZaloPay</span>
                </label>
              </div>

              <div className='checkpay'>
                <label htmlFor='shopeepay'>
                  <Radio
                    {...controlProps('shopeepay')}
                    color='default'
                    name='pay'
                    id='shopeepay'
                  />

                  <img
                    src='https://minio.thecoffeehouse.com/image/tchmobileapp/1120_1119_ShopeePay-Horizontal2_O.png'
                    alt=''
                  />
                  <span>ShopeePay</span>
                </label>
              </div>
            </div>
            <div className='agree'>
              <Checkbox {...label} color='secondary' name='agree' />
              <span>
                {' '}
                Đồng ý với các điều khoản và{' '}
                <span>
                  <Link to='#/'> điều kiện mua hàng </Link>
                </span>{' '}
                của The Coffee House
              </span>
            </div>
          </form>
        </div>
        <div className='body__bill'>
          <div className='bill'>
            <p className='bill_Name'>Các món đã chọn</p>
            <div className='add_item'>
              <Link to='/Product'>
                <p>Thêm món</p>
              </Link>
            </div>
          </div>
          <ul className='list__bill'>
            {get.map((item, index) => (
              <li key={index} className='list__bill-Iteam'>
                <div className='list_fix'>
                  <i className='fad fa-acorn'></i>
                </div>
                <div className='list_text'>
                  <b className='tilte_item'>{item.title} </b>

                  <p className='size'>{item.TitleSize}</p>
                  <p className='btn_delete' onClick={() => removeItem(index)}>
                    Xóa
                  </p>
                </div>
                <div className='list_price'>
                  <p>
                    {(item.price * 1).toLocaleString(undefined, {
                      minimumFractionDigits: 0,
                    })}
                    đ
                  </p>
                </div>
              </li>
            ))}
          </ul>
          <div className='Total'>
            <p className='bill_Name'>Tổng cộng</p>
            <div className='thanhtien'>
              <p>Thành tiền</p>
              <p className='price_total'>
                {total?.toLocaleString(undefined, { minimumFractionDigits: 0 })}
                đ
              </p>
            </div>{' '}
            <div
              className='khuyenmai d-flex justify-content-between'
              onClick={() => dispatch(actionKM(KMOpen))}>
              {discount?.Id ? (
                <>
                  <p
                    style={{
                      width: '60%',
                      overflow: 'hidden',
                      whiteSpace: 'nowrap',
                      textOverflow: 'ellipsis',
                    }}>
                    Khuyến mãi: {discount?.Name}
                  </p>
                  {
                    (preTotal < discount?.MinPrice || Date.now() > dateEx) && (
                    <span
                      style={{
                        color: 'red',
                        lineHeight: '70px',
                        display: 'block',
                      }}>
                      
                      (Không thể áp dụng)
                    </span>
                  )}
                </>
              ) : (
                <p>Khuyến mãi</p>
              )}
              <i className='fa fa-chevron-right'></i>
            </div>{' '}
            <div className='dathang d-flex justify-content-between p-2 lh-3'>
              <div className='thanhtien_main d-flex flex-column justify-content-center'>
                <p>Thành tiền</p>
                <p className='price_total'>
                  {total?.toLocaleString(undefined, {
                    minimumFractionDigits: 0,
                  })}
                  đ
                </p>
              </div>
              <div onClick={OnSubmit}>
                <Loading loading={loading} success={success} />
              </div>
            </div>
          </div>
          <div className='delete_Bill'>
            <p
              onClick={() => {
                localStorage.removeItem('LISTBILL');
                SetGet([]);
                dispatch(reset());
              }}>
              Xóa tất cả
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default memo(Checkout);
