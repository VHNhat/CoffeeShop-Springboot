/* eslint-disable jsx-a11y/alt-text */
import Fade from '@mui/material/Grow';
import Paper from '@mui/material/Paper';
import { useSnackbar } from 'notistack';
import React, { useContext, useEffect, useState } from 'react';
import { getRoleId, updateRole } from '../../app/ApiResult';
import { context } from '../../app/Context';
import Role from './../Role/index';
import './stylesUpdateComponent/UpdateRole.scss';
function UpdateRole(props) {
  const Context = useContext(context);
  const { id } = props; 
  const { setBodyAdmin, setFillerAdmin } = Context;
  const { enqueueSnackbar } = useSnackbar();
  const [valueData, setValueData] = useState({
    Id:'',
    RoleName: '',
    Description: '',
 
  });
  // eslint-disable-next-line no-undef
  // eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(async() => {
    const result = await getRoleId(id,"/role")
    
  if(result){

    setValueData({
      ...valueData,
      Id:result.Id,
      RoleName: result.RoleName,
      Description: result.Description,
  
    })
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }},[id])
  const handleChangeData = (event) => {
    setValueData({
      ...valueData,
      [event.target.name]: event.target.value,
    });
  };
  const HandleUpload = async () => {
    const res = await updateRole(valueData)
    if(res?.success)
      enqueueSnackbar('Tải lên thành công', { variant: 'success' });
    else  enqueueSnackbar('Tải lên thất bại', { variant: 'error' });
  };
  function Prev() {
    setBodyAdmin(<Role />);
    setFillerAdmin('ROLE');
  }
  return (
    <div className='UpdateRole'>
      <Fade in={true} timeout={200} style={{ height: '100%' }}>
        
        <Paper>
        <button
           style={{width:'fit-content',position:'absolute'}}
            type='button'
            className='btn btn-success d-flex gap-2'
            onClick={() => Prev()}>
            <i
              style={{ fontSize: '1.5rem' }}
              className='fad fa-chevron-circle-left'></i>
            <p className> Quay lại</p>
          </button>
          <h2 className='text-center pt-4'>Cập nhật quyền </h2>
          <p  style={{width:'50%',margin:'0 auto'}}>Mã quyền:{id}</p>
          <div className='dataAdd'>
            <div className='form-floating mb-3 inputData'>
              <input
                type='text'
                className='form-control '
                name='RoleName'
                color='warning'
                value={valueData?.RoleName}
                onChange={handleChangeData}
              />
              <label htmlFor='floatingInput'>Tên quyền</label>
            </div>

            <div className='form-floating mb-3 inputData'>
              <input
                type='text'
                className='form-control'
                name='Description'
                color='warning'
                value={valueData?.Description}
                onChange={handleChangeData}
              />

              <label htmlFor='floatingInput'>Mô tả </label>
            </div>
           
            <div className='inputData'>
              <button
                type='submit'
                className='btn btn-success inputData'
                style={{ width: '100%', margin: '0 auto' }}
                onClick={HandleUpload}>
                Cập nhật 
              </button>
            </div>
          </div>
        </Paper>
      </Fade>
    </div>
  );
}

export default UpdateRole;
